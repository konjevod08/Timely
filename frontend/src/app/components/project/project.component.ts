import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Subscription } from 'rxjs';
import { Project } from 'src/app/Project';
import { ProjectService } from 'src/app/services/project.service';
import { DialogComponent } from '../dialog/dialog.component';

import { faTimes } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  projects: Project[] = [];
  faTimes = faTimes;
  clicked: boolean = false;
  name: string='';
  subscription: Subscription = new Subscription;
  projectForSave!: Project;
  startDate!: Date;
  endDate!: Date;
  duration: String='';

  constructor(private projectService: ProjectService, public dialog: MatDialog) { }

  openDialog(): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      width: '250px',
      data: {name: this.name},
    });

    dialogRef.afterClosed().subscribe(result => {
      
      if(result){

        this.endDate = new Date()
        this.projects.pop();
        
        let diffMs = this.endDate.getTime() - this.startDate.getTime(); // milliseconds
        let diffDays = Math.floor(diffMs / 86400000); // days
        let diffHrs = Math.floor((diffMs % 86400000) / 3600000); // hours
        let diffMins = Math.round(((diffMs % 86400000) % 3600000) / 60000); // minutes
        let diffSeconds =  Math.round((((diffMs % 86400000) % 3600000) % 60000) / 1000);

        this.projectForSave = {
          name: result,
          startingDate: this.startDate,
          endingDate: this.endDate,
          duration: diffDays + " days, " + diffHrs + " hours, " + diffMins + " minutes, " + diffSeconds + " seconds"
        };
        
        this.projectService.addProject(this.projectForSave).subscribe((projectForSave) => (this.projects.push(projectForSave)));
        this.clicked = !this.clicked;
      }
    });
  }

  onStartStop(){
    if(!this.clicked){
      this.startDate = new Date()
      this.projectForSave = {
        name: "...",
        startingDate: new Date(),
        endingDate: null,
        duration:"..."
      };
      this.projects.push(this.projectForSave);
      console.log(this.projectForSave)

      //alert("Kliknuo start");
      this.clicked = !this.clicked;
    }else{

      this.openDialog();
      //alert("Kliknuo stop");
    }
  }
  onDelete(project:Project) {
    this.projectService
      .deleteProject(project)
      .subscribe(
        () => (this.projects = this.projects.filter((p) => p.id !== project.id))
      );
  }

  ngOnInit(): void {
    this.projectService.getProjects().subscribe((data: Project[]) => {
      this.projects = data;
    });
  }

}
