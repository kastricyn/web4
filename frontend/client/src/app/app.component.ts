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
  constructor(private app: AuthService, private http: HttpClient, private router: Router) {
    this.app.authenticate(undefined, undefined);
  }

  logout() {
    this.http.post('logout', {}).pipe(finalize(() => {
      this.app.authenticated = false;
      this.router.navigateByUrl('/login');
    })).subscribe();
  }
}
