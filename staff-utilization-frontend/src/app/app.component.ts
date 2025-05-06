import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UtilizationRecord } from './utilizationRecord';
import { UtilizationRecordService } from './utilizationRecord.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  public utilizationRecords: UtilizationRecord[] = [];

  constructor( private utilizationRecordService: UtilizationRecordService ){}

  public getEmployees(): void {
    this.utilizationRecordService.getUtilizationRecords().subscribe(
      (response: UtilizationRecord[]) => {
        this.utilizationRecords = response;
        //console.log(this.utilizationRecords);
      },
      (error) => {
        alert(error.message);
      }
    );
  }

}
