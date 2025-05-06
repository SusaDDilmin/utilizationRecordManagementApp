import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UtilizationRecord } from './utilizationRecord';

@Injectable({
  providedIn: 'root'
})

export class UtilizationRecordService {
    private apiServerUrl = ''; // Update with your API URL

    constructor(private http: HttpClient) { }

    public getUtilizationRecords(): Observable<UtilizationRecord[]> {
        return this.http.get<UtilizationRecord[]>(`${this.apiServerUrl}/utilizationRecord/all`);
    }


    public addUtilizationRecord(utilizationRecord: UtilizationRecord): Observable<UtilizationRecord> {
        return this.http.post<UtilizationRecord>(`${this.apiServerUrl}/utilizationRecord/add`, utilizationRecord);
    }


    public updateUtilizationRecord(utilizationRecord: UtilizationRecord): Observable<UtilizationRecord> {
        return this.http.put<UtilizationRecord>(`${this.apiServerUrl}/utilizationRecord/update`, utilizationRecord);
    }

    public deleteUtilizationRecord(utilizationRecordId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/utilizationRecord/delete${utilizationRecordId}`);
    }

}
