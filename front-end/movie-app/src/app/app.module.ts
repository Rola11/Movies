import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms'; // Import FormsModule
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {AuthInterceptor} from "./auth.interceptor";
import {HeaderComponent} from './header-component/header.component';
import {SearchComponent} from './search/search.component';
import {ListComponent} from './list/list.component';
import { UserMovieListComponent } from './user-movie-list/user-movie-list.component';
import { FilmDetailsComponent } from './film-details/film-details.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    SearchComponent,
    ListComponent,
    UserMovieListComponent,
    FilmDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
