import React, { Component } from 'react';
import './App.css';
import axios from 'axios';
import { faMinus } from "@fortawesome/free-solid-svg-icons";
import { faBook } from "@fortawesome/free-solid-svg-icons"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { BrowserRouter as Router, Link, Route} from "react-router-dom";

class AddNewBook extends Component {
  constructor(props){
    super(props);
    this.state = {
        title: "",
        authors: "",
        category: "",
        numberOfPages: 321,
        readPages: 4342,
        yearOfPublishing: 423,
    }

    this.handleFormChange = this.handleFormChange.bind(this);
    this.handleAdd = this.handleAdd.bind(this);
  }

  //Add handlers for forms to read its values and send those on submit
  handleFormChange(event){
    let val = {};
    val[event.target.id] = event.target.value;
    this.setState(val);
    console.log(this);
  }

  handleAdd(event){
    let book = this.state;
    axios.post(`http://localhost:8080/books`,book)
    .then(res => {
      console.log(res);
      console.log(book);
    });
    
  }

  render(){
    return (
      <form onSubmit={this.handleAdd}>
        <div className="form-group col-md-6 addForm">
          <label htmlFor="title">Title</label>
          <input onChange={this.handleFormChange} value={this.state.title} type="text" className="form-control" id="title" placeholder="Title" required></input>
        </div>
        <div className="form-group col-md-6 addForm">
          <label htmlFor="authors">Authors</label>
          <input onChange={this.handleFormChange} value={this.state.authors} type="text" className="form-control" id="authors" placeholder="Authors" required></input>
        </div>
        <div className="form-group col-md-6 addForm">
          <label htmlFor="category">Category</label>
          <input onChange={this.handleFormChange} value={this.state.category} type="text" className="form-control" id="category" placeholder="Category" required></input>
        </div>
        <div className="form-group col-md-6 addForm">
          <label htmlFor="numberOfPages">Pages</label>
          <input onChange={this.handleFormChange} value={parseInt(this.state.numberOfPages)} type="text" className="form-control" id="numberOfPages" placeholder="Number of pages of the book" required></input>
        </div>
        <div className="form-group col-md-6 addForm">
          <label htmlFor="readPages">Read</label>
          <input onChange={this.handleFormChange} value={parseInt(this.state.readPages)} type="text" className="form-control" id="readPages" placeholder="Number of pages already read" required></input>
        </div>
        <div className="form-group col-md-6 addForm">
          <label htmlFor="yearOfPublishing">Year</label>
          <input onChange={this.handleFormChange} value={parseInt(this.state.yearOfPublishing)} type="text" className="form-control" id="yearOfPublishing" placeholder="Year of publishing" required></input>
        </div>
        <div className="col-md-6 addForm">
          <button id="addButton" type="submit" className="btn btn-primary">Add</button>
        </div>
      </form>
    );
  }
}


class MyBooks extends Component {
  constructor(props){
    super(props);
    this.state={
      books: []
    }

    this.handleDelete = this.handleDelete.bind(this);
  }

  getBook(index){
    return this.state.books[index];
  }

  componentDidMount() {
    axios.get(`http://localhost:8080/books`)
      .then(res => {
        const books = res.data;
        this.setState({ books });
      });

  }

  handleDelete(event){
    const index = event.target.id;
    console.log(index);
  }



  render() {
    return (
      <div className="container">
        <div>
          <h1 className="header">My Books</h1>
        </div>
        <table className="table table-sm">
          <thead>
            <tr>
              <th>Title</th>
              <th>Authors</th>
              <th>Category</th>
              <th>Pages</th>
              <th>Read</th>
              <th>Year</th>
              <th></th>
            </tr>
        </thead>
        <tbody>
        {this.state.books.map(book =>
          <tr key={book.id}>
            <td>{book.title}</td>
            <td>{book.authors}</td>
            <td>{book.category}</td>
            <td>{book.numberOfPages}</td>
            <td>{book.readPages}/{book.numberOfPages}</td>
            <td>{book.yearOfPublishing}</td>
            <td><button onClick={this.handleDelete} className="btn btn-outline-secondary" id={book.id - 1}><FontAwesomeIcon icon={faMinus}/></button></td>
          </tr>
        )}
        </tbody>
        </table>
        
        
      </div>
    );
  }
}

class App extends Component {
  

  render() {
    return (
          <Router>
            <div className="App container">
              <nav className="navbar navbar-expand-lg navbar-light" id="navigation">
                <Link className="navbar-brand" to={"/"}><FontAwesomeIcon icon={faBook} id="bookIcon"/><span id="brandname"> BookManager</span></Link>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                  <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                  <div className="navbar-nav">
                    <Link className="nav-item nav-link active" to={"/"}>MyBooks <span className="sr-only">(current)</span></Link>
                    <Link className="nav-item nav-link active" to={"/wishlist"}>Whishlist</Link>
                    <Link className="nav-item nav-link active" to={"/add"}>Add New Book</Link>
                  </div>
                  <form className="form-inline my-2 my-lg-0">
                    <input className="form-control mr-sm-2" type="search" placeholder="Title" aria-label="Search"></input>
                    <button id="searchButton" className="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
                  </form>
                </div>
              </nav>
            
              <Route exact={true} path={"/"} render={() => (
                <div className="container booklist"><MyBooks /></div>
              )}/>
              <Route exact={true} path={"/add"} component={AddNewBook} />
            </div>
          </Router>
    );
  }
}

export default App;
