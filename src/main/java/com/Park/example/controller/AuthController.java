package com.Park.example.controller;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Park.example.config.JwtUtils;
import com.Park.example.domain.Board;
import com.Park.example.domain.Order;
import com.Park.example.domain.Product;
import com.Park.example.domain.User;
import com.Park.example.domain.UserInfo;
import com.Park.example.request.JoinRequest;
import com.Park.example.request.LoginRequest;
import com.Park.example.response.JwtResponse;
import com.Park.example.service.UserService;
import com.Park.example.service.BoardService;
import com.Park.example.service.OrderService;
import com.Park.example.service.ProductService;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserService userService;
	
	@Autowired
	BoardService boardservice;
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	ProductService productservice;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {

		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		User user = (User) authentication.getPrincipal();		
		List<String> roles = user.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 user.getUsername(), 
												 user.getName(),  
												 roles));
	}
	@PostMapping("/signup")
	   public ResponseEntity<?> sinupUser(@Validated @RequestBody JoinRequest joinRequest) {
	      
	      String encodedPassword = new BCryptPasswordEncoder().encode(joinRequest.getPassword());
	      
	      User user = new User();

	      user.setUsername(joinRequest.getUsername());
	      user.setName(joinRequest.getName());
	      user.setPassword(encodedPassword);
	      user.setPhone(joinRequest.getPhone());
	      user.setAddress(joinRequest.getAddress());
	      user.setAccountNonExpired(true);
	      user.setEnabled(true);
	      user.setAccountNonLocked(true);
	      user.setCredentialsNonExpired(true);
	      user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
	      

	      userService.createUser(user);

	      userService.createAuthority(user);
	      
	      return new ResponseEntity<>("success", HttpStatus.OK);
	   }
	@GetMapping("/unpackToken")
	public ResponseEntity<?> unpackToken(HttpServletRequest request) {
		String token = new String();
		token =  request.getHeader("Authorization");
		
		if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
			token =  token.substring(7, token.length());
		}
		String username = jwtUtils.getUserEmailFromToken(token);
		UserInfo user = userService.readUser_refresh(username);
		logger.info("dddd" + user.toString()); 
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/boardinsert")
	public ResponseEntity<?> boardinsert(@RequestBody Board board) {
		boardservice.boardinsert(board);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@GetMapping("/productPage")
	public ResponseEntity<?> productList() {
		List<Board> list = boardservice.productPage();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/productEdit")
	public ResponseEntity<?> productEdit(@RequestBody Board board) {
		logger.info(board.getB_content());
		boardservice.productEdit(board);
		List<Board> list = boardservice.productPage();
		logger.info(list.toString());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/productDetail")
	public ResponseEntity<?> productDetail(@RequestBody Board board) {
		logger.info(Integer.toString(board.getB_idx()));
		Board boardDetail = boardservice.productDetail(board.getB_idx());
		
		return new ResponseEntity<>(boardDetail, HttpStatus.OK);
		
	}
	
	@PostMapping("/productDelete")
	public ResponseEntity<?> productDelete(@RequestBody Board board) {
		logger.info(Integer.toString(board.getB_idx()));
		boardservice.productDelete(board.getB_idx());
		List<Board> list = boardservice.productPage();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	@PostMapping("/order")
	public ResponseEntity<?> order(@RequestBody Order order) {
		orderservice.orderinsert(order);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
		
	}
	@GetMapping("/orderList")
	public ResponseEntity<?> orderList() {
		List<Order> list = orderservice.orderList();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/orderMonth")
	public ResponseEntity<?> orderMonth() {
		List<Order> list = orderservice.orderMonth();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/orderWeekly")
	public ResponseEntity<?> orderWeekly() {
		List<Order> list = orderservice.orderWeekly();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/productMenu1")
	public ResponseEntity<?> productMenu1(@RequestBody Board board) {
		logger.info(Integer.toString(board.getP_idx()));
		List<Board> list = boardservice.productMenu1(board.getP_idx());
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/productCategory")
	public ResponseEntity<?> productCategory() {
		List<Product> list = productservice.productCategory();
			
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile multipartFile) {
		String path="C:\\Users\\l10\\Documents\\work\\Park\\src\\main\\resources\\static\\image";
		String thumbPath = path +"thumb/";
		String filename = multipartFile.getOriginalFilename();
		String ext = filename.substring(filename.lastIndexOf(".")+1);
		
		File file = new File(path + filename);
		File thumbFile = new File(thumbPath + filename);
		try {
			//원본파일 저장
			InputStream input = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(input, file);
			
			//썸네일 생성
			BufferedImage imageBuf = ImageIO .read(file);
			int fixWidth = 500;
			double ratio = imageBuf.getWidth() / (double)fixWidth;
			int thumbWidth = fixWidth;
			int thumbHeight = (int)(imageBuf.getHeight() / ratio);
			BufferedImage thumbImageBf = new BufferedImage(thumbWidth, thumbHeight,BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D g = thumbImageBf.createGraphics();
			Image thumbImage = imageBuf.getScaledInstance(thumbWidth, thumbHeight, Image.SCALE_SMOOTH);
			g.drawImage(thumbImage, 0, 0, thumbWidth, thumbHeight, null);
			g.dispose();
			ImageIO.write(thumbImageBf, ext,thumbFile);
		} catch (IOException e) {
			FileUtils.deleteQuietly(file);
			e.printStackTrace();
		}
		return new ResponseEntity<>("success", HttpStatus.OK);
		
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


