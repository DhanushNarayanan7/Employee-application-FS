package com.empapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empapp.model.LoginMasterInfo;
import com.empapp.repository.LoginRepository;

//import com.empapp.constants.CommonConstants;
//import com.empapp.dto.LoginDTO;
//import com.empapp.dto.StatusResponseDTO;
//import com.empapp.service.LoginService;
//import com.empapp.utils.CommonServiceUtils;
//import com.empapp.utils.LoginUtils;


@Controller
@RequestMapping(value = "/base")
@CrossOrigin
public class LoginController {

	
	@Autowired
	private LoginRepository loginrepo;
	
//	@Autowired
//	private LoginUtils loginUtils;
//
//	@Autowired
//	private LoginService loginService;

	@GetMapping("/")
	public String homepage() {
		System.out.println("Test method returns");
		return "login";
	}
	
	@PostMapping("/login")
	public String login_validation(@RequestParam("userMail") String userMail , @RequestParam("password") String password, ModelMap modelmap) {
		LoginMasterInfo logininfo = loginrepo.findLoginMasterInfoByUserMailAndPassword(userMail, password);
		if(logininfo==null) {
			modelmap.put("errorMessage","Username or password is not correct. Authentication failure");
			return "failure";
		}else {
			String username = logininfo.getUserMail().split("@")[0];
			modelmap.put("name",username);
			return "success";			
		}
	}

	/**
	 * API functionality to validate the login credentials based on 'UserMail' and
	 * 'Password' fields
	 * 
	 * @param loginDTO
	 * @return {@link StatusResponseDTO}
	 */
//	@CrossOrigin
//	@RequestMapping(value = CommonConstants.LOGIN_VALIDATE_URL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> getLoginValidation(@RequestBody LoginDTO loginDTO) {
//
//		log.debug("Enter the getLoginValidation() method... ");
//		StatusResponseDTO responseDTO = new StatusResponseDTO();
//		responseDTO.setStatus(env.getProperty(CommonConstants.FAILURE.getValue()));
//
//		try {
//			System.out.println(loginDTO.getUserMail());
//			System.out.println(loginDTO.getPassword());
//			if (!loginUtils.isValidateLoginParam(loginDTO)) {
//				log.info("Please enter correct login credentials");
//				return CommonServiceUtils.jsonResponseEntityFailureWithMsg(responseDTO, env,
//						env.getProperty(CommonConstants.INCORRECTDETAILS.getValue()), null);
//			}
//
//			loginService.loginValidation(responseDTO, loginDTO); //why ResponseDTO is not returned as local and assigned
//			log.debug("Exit the getLoginValidation() method... ");
//			return CommonServiceUtils.jsonResponseEntitySuccess(responseDTO, env, responseDTO.getMessage());
//		} catch (Exception e) {
//			log.error("Error occured in getLoginValidation method... " + e.getMessage());
//			return CommonServiceUtils.jsonResponseEntityFailure(responseDTO, env, e);
//		}
//	}
}
