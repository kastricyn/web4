import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from "../model/user";
import {finalize} from "rxjs";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  get answerToUser(): string {
    return this._answerToUser;
  }

  private readonly host: string = "http://localhost:8080/";
  private _authenticated: boolean = false;
  private _user: User = new User("")
  private _answerToUser: string = "";

  constructor(private http: HttpClient, private router: Router) {
  }

  authenticate(credentials: { login: string; password: string; } | undefined, callback: { (): void; (): any; } | undefined) {

    this.http.post(this.host + 'api/users/loginWithRegister', credentials).subscribe(response => {
      // @ts-ignore
      if (response["token"]) {
        this.user.login = credentials?.login ? credentials.login : ""
        this._authenticated = true;
        // @ts-ignore
        localStorage.setItem('auth_token', response.token);
      } else {
        this._authenticated = false;
      }
      return callback && callback();
    }, error => {
      return callback && callback();
    });
  }

  logout(): void {
    this.http.post('/logout', {}).pipe(finalize(() => {
      this._authenticated = false;
      this.router.navigateByUrl('/login');
    })).subscribe();
    localStorage.removeItem('auth_token');
  }


  get authenticated(): boolean {
    return this._authenticated;
  }

  get user(): User {
    return this._user;
  }

}
