import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  greeting = {};

  constructor(private auth: AuthService, private http: HttpClient) {
    http.get('resource').subscribe(data => this.greeting = data);
  }

  authenticated() { return this.auth.authenticated; }


}
