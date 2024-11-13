import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_BASE_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) {}

  getCategory(): Observable<any[]> {
    return this.http.get<any[]>(`${API_BASE_URL}/categories`);
  }

  createCategory(categoryData: any): Observable<any> {
    return this.http.post<any>(`${API_BASE_URL}/categories`, categoryData);
  }

  updateCategory(id: number, categoryData: any): Observable<any> {
    return this.http.put<any>(`${API_BASE_URL}/categories/${id}`, categoryData);
  }

  deleteCategory(id: number): Observable<any> {
    return this.http.delete<any>(`${API_BASE_URL}/categories/${id}`);
  }

  getChoix(): Observable<any[]> {
    return this.http.get<any[]>(`${API_BASE_URL}/choix`);
  }

  createChoix(choixData: any): Observable<any> {
    return this.http.post<any>(`${API_BASE_URL}/choix`, choixData);
  }

  updateChoix(id: number, choixData: any): Observable<any> {
    return this.http.put<any>(`${API_BASE_URL}/choix/${id}`, choixData);
  }

  deleteChoix(id: number): Observable<any> {
    return this.http.delete<any>(`${API_BASE_URL}/choix/${id}`);
  }
}
