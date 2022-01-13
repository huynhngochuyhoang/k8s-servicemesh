import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment";
import {Noti} from "./Notification";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  notification: string = '';
  unreadNotification: string = '';
  id!: number
  description!: string
  listNoti: string[] = []

  constructor(private http: HttpClient) {
  }

  show() {
    this.http.get(`${environment.apiUrl}/api/checkNotification/showUnreadNotification`, {responseType: "text"})
      .subscribe(response => {
          this.unreadNotification = response
        }
      )
  }

  submit() {
    let noti: Noti = {id: this.id, description: this.description}
    this.http.post(`${environment.apiUrl}/api/checkNotification/create`, noti, {responseType: "text"})
      .subscribe(response => {
        this.listNoti.push(response);
      })
  }

  check() {
    this.http.get(`${environment.apiUrl}/api/checkNotification/refresh`,
      {responseType: "text"})
      .subscribe(notification => {
        this.notification = notification
      })
  }
}
