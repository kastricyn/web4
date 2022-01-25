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
  showMessageCheckLoginOrPassword: boolean = false
  credentials = {login: '', password: ''};

  constructor(private authService: AuthService, private http: HttpClient, private router: Router) {
  }

  clickHandler() {
    this.authService.authenticate(this.credentials, () => {
      if (this.authService.authenticated)
        this.router.navigateByUrl('');
      else{
        this.showMessageCheckLoginOrPassword = true
        // this.router.navigateByUrl('/login');
      }
    });


  }

}
