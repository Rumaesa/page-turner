import { Book } from '../../dto/book';
import { BookService } from './../../services/book.service';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';

@Component({
  selector: 'app-book',
  imports: [CommonModule, TableModule],
  templateUrl: './book.component.html',
  styleUrl: './book.component.scss'
})
export class BookComponent implements OnInit{

  private bookservice: BookService;
  books : Book[] = [];
  constructor(bookservice : BookService){
    this.bookservice = bookservice;
  }

  ngOnInit(): void {
    this.getBooks();
  }

  getBooks(){
    this.bookservice.getBooks().subscribe({
      next: (data) => {
        this.books = data;
        console.log('Books fetched:',this.books);
      },
      error: (err) => {
        console.log('Error fetching books',err);
      }
    });
  }
}
