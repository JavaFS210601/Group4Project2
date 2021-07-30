import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TransferServiceService {

  constructor() { }
  private data!: any;

  setData(data: any) {
    this.data = data;
  }

  getData() {
    console.log(this.data);
    return this.data;
  }


}
