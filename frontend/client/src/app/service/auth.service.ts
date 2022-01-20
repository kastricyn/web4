import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from "../model/user";
import {finalize} from "rxjs";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _authenticated: boolean = false;
  private _user: User = new User("", "")

  constructor(private http: HttpClient, private router: Router) {
  }

  authenticate(credentials: { username: any; password: any; } | undefined, callback: { (): void; (): any; } | undefined) {

    const headers = new HttpHeaders(credentials ? {
      authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.http.get('user', {headers: headers}).subscribe(response => {
      // @ts-ignore
      if (response['name']) {
        this._authenticated = true;
      } else {
        this._authenticated = false;
      }
      return callback && callback();
    });

  }

  logout(): void {
    this.http.post('logout', {}).pipe(finalize(() => {
      this._authenticated = false;
      this.router.navigateByUrl('/login');
    })).subscribe();
  }


  get authenticated(): boolean {
    return this._authenticated;
  }

  get user(): User {
    // return this._user;
    return new User("123", "Макс")
  }

}
