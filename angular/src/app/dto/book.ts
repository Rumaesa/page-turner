export class Book {
  id: number;
  title: string;
  author: string;
  isbn: string;
  publishedDate: Date;
  availableCopies: number;

  constructor(option: Book){
    this.id = option.id;
    this.title = option.title;
    this.author = option.author;
    this.isbn = option.isbn;
    this.publishedDate = option.publishedDate;
    this.availableCopies = option.availableCopies;
  }
}
