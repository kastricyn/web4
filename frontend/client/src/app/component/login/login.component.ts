import {Component} from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-form',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  showMessage: string = ""
  credentials = {login: '', password: ''};
  needRegister: boolean = false

  constructor(private authService: AuthService, private http: HttpClient, private router: Router) {
  }

  clickHandler() {
    let success = true
    if (this.needRegister)
      success = this.regiser()
    if (success)
      this.login()
  }

  login() {
    this.authService.authenticate(this.credentials, () => {
      if (this.authService.authenticated)
        this.router.navigateByUrl('');
      this.showMessage = this.authService.answerToUser
    });
    return false;
  }

  regiser(): boolean {
    this.authService.register(this.credentials, ()=>{

    });
    return false;
  }

}
