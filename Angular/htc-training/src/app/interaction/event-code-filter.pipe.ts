import { Pipe, PipeTransform } from '@angular/core';
import { ParticipantList } from './participant-list';

@Pipe({
  name: 'eventCodeFilter'
})
export class EventCodeFilterPipe implements PipeTransform {

  transform(participants : ParticipantList[] , eventId:string): ParticipantList[]{
    if(!eventId)
        return participants;

    return participants.filter(participant => participant.eventCode == eventId)
                      .sort((participantA , participantB) => participantA.participantName.localeCompare(participantB.participantName));
}

}
