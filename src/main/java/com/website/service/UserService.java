package com.website.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.dto.UserDTO;
import com.website.model.User;
import com.website.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmailService emailService;

	@Autowired
	private ModelMapper modelMapper;

	public void createUser(UserDTO userDTO) {
		User userDetails = modelMapper.map(userDTO, User.class);
		userRepository.save(userDetails);

		String subject = "New Contact Query Submitted";
		String text = String.format("New query submitted by: %s %s\nEmail: %s\nAddress: %s\nMessage: %s",
				userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getAddress(),
				userDTO.getMessage());
		emailService.sendEmail("alibrahimmahavidhyalaya@gmail.com", subject, text, userDTO.getMobileNumber());
	}

}
