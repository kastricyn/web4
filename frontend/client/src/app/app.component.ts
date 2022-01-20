import {Component} from '@angular/core';
import {AuthService} from './service/auth.service';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import { finalize } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(private authService: AuthService, private http: HttpClient, private router: Router) {
    this.authService.authenticate(undefined, undefined);
  }

}
