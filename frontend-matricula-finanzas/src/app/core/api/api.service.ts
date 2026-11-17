import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { APP_CONFIG } from '../config';

@Injectable({ providedIn: 'root' })
export class ApiService {
  private readonly http = inject(HttpClient);
  private readonly base = APP_CONFIG.apiBaseUrl;

  list<T>(path: string): Observable<T[]> {
    return this.http.get<T[]>(`${this.base}${path}`);
  }

  get<T>(path: string, id: number | string): Observable<T> {
    return this.http.get<T>(`${this.base}${path}/${id}`);
  }

  create<T>(path: string, body: Partial<T>): Observable<T> {
    return this.http.post<T>(`${this.base}${path}`, body);
  }

  update<T>(path: string, id: number | string, body: Partial<T>): Observable<T> {
    return this.http.put<T>(`${this.base}${path}/${id}`, body);
  }

  remove(path: string, id: number | string): Observable<void> {
    return this.http.delete<void>(`${this.base}${path}/${id}`);
  }

  action<T>(path: string, id: number | string, action: string, body?: unknown): Observable<T> {
    return this.http.post<T>(`${this.base}${path}/${id}/${action}`, body ?? {});
  }
}
