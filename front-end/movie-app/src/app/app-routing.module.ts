import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {LoginComponent} from './login/login.component';

import {AuthGuard} from './auth.guard';
import {SearchComponent} from "./search/search.component";
import {ListComponent} from "./list/list.component";
import {UserMovieListComponent} from "./user-movie-list/user-movie-list.component";
import { FilmDetailsComponent } from './film-details/film-details.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'user-movies', component: UserMovieListComponent },
  { path: 'movie-details/:id', component: FilmDetailsComponent },
  {path: 'search', component: SearchComponent, canActivate: [AuthGuard], data: {role: 'ADMIN'}},
  {path: 'list', component: ListComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}




