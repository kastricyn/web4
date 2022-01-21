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
  private readonly url: string = "api/users/login";
  private readonly urlTest: string = "echo";
  private _authenticated: boolean = false;
  private _user: User = new User("", "")
  private _answerToUser: string = "";

  constructor(private http: HttpClient, private router: Router) {
  }

  authenticate(credentials: { login: string; password: string; } | undefined, callback: { (): void; (): any; } | undefined) {
    this.register(credentials, ()=>null);
    console.log("login start")
    const headers = new HttpHeaders(credentials ? {
      authorization: 'Basic ' + btoa(credentials.login + ':' + credentials.password)
    } : {});

    this.http.post(this.host + 'api/users/login', credentials, {headers: headers}).subscribe(response => {
      // @ts-ignore
      if (response["token"]) {
        this._answerToUser = ""
        this._authenticated = true;
      } else {
        this._authenticated = false;
      }
      return callback && callback();
    }, error => {
      if(error.status == 400)
        this._answerToUser = "Проверьте корректность Login & Password"
    });

  }
  register(credentials: { login: string; password: string; } | undefined, callback: { (): void; (): any; } | undefined) {
    console.log("Register start")
    this.http.post(this.host + 'api/users/register', credentials).subscribe(response => {
      // @ts-ignore
      if (response["token"]) {
        this._answerToUser = ""
        this._authenticated = true;
      } else {
        this._authenticated = false;
      }
      return callback && callback();
    }, error => {
      if(error.status == 400)
        this._answerToUser = error.error["message"]
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
