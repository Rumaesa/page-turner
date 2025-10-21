import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../dto/book';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private readonly apiUrl = 'http://localhost:8080/book-service/api';
  private readonly headers: HttpHeaders;
  constructor(
    private readonly http: HttpClient,
  ) {
    this.headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
    });
  }

  getBooks(): Observable<Book[]>{
    const newUrl = this.apiUrl + '/books';
    return this.http.get<Book[]>(newUrl);
  }

  getBookById(id: string): Observable<Book>{
    const newUrl = this.apiUrl + '/books/'+id;
    return this.http.get<Book>(newUrl);
  }

  saveBook(book: Book): Observable<string>{
    const newUrl = this.apiUrl + '/saveBook';
    return this.http.post(newUrl, book, { responseType: 'text' });
  }

}
