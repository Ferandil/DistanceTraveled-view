package userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import userservice.model.User;
import userservice.model.User;
import userservice.model.UserCoord;
import userservice.service.UserService;

@Controller
public class UploadController {
    UserService userService;
    //@PostMapping(value = "/upload")
   // public @ResponseBody String handleFileUpload(@RequestParam("Accept") String post){
     //   System.out.println(post);
      //  return null;
   // }

    public UploadController(UserService userService){
        this.userService = userService;
    }

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService){
        this.userService = userService;
    }
    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> readCoord(@RequestBody UserCoord userCoord){
        System.out.println(userCoord.getDate());
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //@PostMapping(value = "/upload")
    //public ResponseEntity<Void> postHandler(@RequestBody UserCoord userCoord, UriComponentsBuilder builder){
    //    //MultiValueMap<String, UserCoord> userCoordMap = (MultiValueMap<String, UserCoord>) userCoordHttp.getBody();
    //    HttpHeaders headers = new HttpHeaders();
    //    System.out.println(userCoord.getDate());
    //    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    //}

    @RequestMapping(value = "/upload/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> clientLogin(@RequestBody User user){
        User userDataToCheck;
        HttpHeaders headers = new HttpHeaders();
        if((userDataToCheck = userService.findByLogin(user.getLogin())) != null){
            if(user.getHashPassword().equals(userDataToCheck.getHashPassword())){
                System.out.println(user.getFirstName() + " logged");
                return new ResponseEntity<>(headers, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
    }
}
