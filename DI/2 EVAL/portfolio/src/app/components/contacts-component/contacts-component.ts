import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-contacts-component',
  imports: [
    FormsModule
  ],
  templateUrl: './contacts-component.html',
  styleUrl: './contacts-component.css',
})
export class ContactsComponent {
  model = {
    name: '',
    email: '',
    message: '',
  };

  onSubmit() {
    console.log('Сообщение отправлено (демо):', this.model);
    alert('Gracias por tu mensaje! (demo, sin envío real todavía)');
  }
}
