import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../Project';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private getUrl = "http://localhost:8080/projects/all";
  private addUrl = "http://localhost:8080/projects/add";
  private deleteUrl = "http://localhost:8080/projects/delete";

  constructor(private http: HttpClient) { }

  getProjects(): Observable<Project[]>{
    return this.http.get<Project[]>(`${this.getUrl}`);
  }

  addProject(project: Project): Observable<Project> {
    return this.http.post<Project>(this.addUrl, project, httpOptions);
  }

  deleteProject(project: Project): Observable<Project> {
    const url = `${this.deleteUrl}/${project.id}`;
    return this.http.delete<Project>(url);
  }
}
