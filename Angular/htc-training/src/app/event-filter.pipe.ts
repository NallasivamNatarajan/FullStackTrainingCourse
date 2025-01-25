import { Pipe, PipeTransform } from '@angular/core';
import { Events } from './events';

@Pipe({
  name: 'eventFilter'
})
export class EventFilterPipe implements PipeTransform {

  transform(eventList: Events[], evntName: string): Events[] {
    let filteredEvent = eventList.filter(event => {
      if(!evntName){
        return event;
      }else{
        return event.eventName==evntName;
      }
    })
    return filteredEvent;
  }

}
