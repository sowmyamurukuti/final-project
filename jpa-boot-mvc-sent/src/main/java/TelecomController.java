

import org.deloitte.telecom.dao.IUserDao;
import org.deloitte.telecom.dto.SessionData;
import org.deloitte.telecom.entities.MobileUser;
import org.deloitte.telecom.exceptions.MobileNoAlreadyExistsException;
import org.deloitte.telecom.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TelecomController {
    private static Logger Log= LoggerFactory.getLogger(TelecomController.class);

    private IUserService service;

    public IUserService getService() {
        return service;
    }

    @Autowired
    public void setService(IUserService service) {
        this.service = service;
    }

    private SessionData sessionData;

    @Autowired
    public void setSessionData(SessionData data) {
        this.sessionData = data;

    }

    public SessionData getSessionData() {
        return sessionData;
    }


    @GetMapping("/userinput")
    public ModelAndView userInput(@RequestParam(name="message", required=false) String message) {
        return new ModelAndView("userinput");
    }

    @GetMapping("/logincheck")
    public Object loginCheck(@RequestParam("phone") String mobileNo,
                                   @RequestParam("password") String password) {
        boolean correct = service.checkCredentialsByMobileNo(mobileNo, password);
        if (!correct) {
            return new RedirectView("/userinput?message=incorrectcredentials");
        }
        MobileUser user = service.findByMobileNo(mobileNo);
        sessionData.setUser(user);
        return new RedirectView("/home");
    }


    @GetMapping("/home")
    public Object home() {
        if (sessionData.getUser() == null) {
            return new RedirectView("/userinput");
        }
        MobileUser mobUser = sessionData.getUser();
        ModelAndView mv = new ModelAndView("home", "user", mobUser);
        return mv;
    }


    @GetMapping("/processregister")
    public RedirectView processRegister(@RequestParam("name") String name,
    								@RequestParam("password") String password,
                                        @RequestParam("mobileNo")String mobileNo,
                                        @RequestParam("balance") double balance)      
    {
    	MobileUser user = new MobileUser(name, password, mobileNo, balance);
        user.setMobileNo(mobileNo);
        user = service.save(user);
        sessionData.setUser(user);
        return new RedirectView("/home");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("/register");

    }

    @GetMapping("/signout")
    public RedirectView signout() {
        sessionData.setUser(null);
        return new RedirectView("/userinput");
    }

    /*
    @GetMapping("/error")
  
    public ModelAndView error(){
        return new ModelAndView("error","message","something went wrong");
    }
    */
    
    @ExceptionHandler(MobileNoAlreadyExistsException.class)
    public ModelAndView handleIfMobileNumberAlreadyExists(MobileNoAlreadyExistsException e){
      return new ModelAndView("error","message","mobilenumber already exists");
    }

    @ExceptionHandler(value = Throwable.class)
    public ModelAndView catchAll(Throwable e){
        e.printStackTrace();
      return new ModelAndView("error","message","Something went wrong");
    }


}
