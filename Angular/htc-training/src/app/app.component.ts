import { Component, EventEmitter, Output , SchemaMetadata } from '@angular/core';
interface participants{
  participantName:string;
  email:string;
  eventCode:string;
}
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'htc-training';
  dashboardTitle = 'Online Courses - Registration App';
  sideNavigationTitle = 'Routes'
  CUSTOM_ELEMENTS_SCHEMA!: SchemaMetadata;
  sideBarOpen = true;
  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }

  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }


}
