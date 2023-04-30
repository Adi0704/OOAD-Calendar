# Calendar-Management-System
This is a eCalendar Management System (EMS).

In this system, the date is 8-digit as YYYYMMDD, the time is 4-digit as HHMM, every input of date or time is expected to follow this rule.

when top shows "Calendars"-"All", it means all the calendars are presented. It is also the first and main page that user will see. Use ``Show All Calendars`` to return to this page at any time. 

Also, it will shows "Timeplots"-"Personal" (timeplots of "Personal" calendar) or "Meetings"-"20180927" (meetings of date 2018-Sept-27th) or "Meeting"-"1000" (people of meeting at 10:00).

## Left 
Left part of interface includes ``Show All Calendars``,``Show Date Schedule`` ``SHow Month Schedule``, ``Close Timeplot``, ``Save`` and ``Quit``.

In this system, ``Save`` will save the hashtable of calendars ("Calendar Manager"), close time/date ("CloseTime(date)List") variables with serializing as "tempMgr.out", "tempCD.out" and "tempCT.out".   

Noted that, "Quit" will not "save" data, it just quits.

## Right
Right Part of interface includes ``Add + ``, ``Load =`` and ``Remove -``

### Load

To load the calendar with name, click ``Load =`` under the "Calendars"-"All", and user will see the timeplots of that calendar with status "activated/closed".

To load the timeplot with date, click ``Load =`` under the "Timeplots"-"_somename_", then user can see the meetings that added in that timeplot. Every timeplot can be loaded even if it is "closed", since user may check the meetings that added before its closing. The "closed" status only prevents the ``add`` meetings infomation to add in the variable, even user clicks ``ok``. 

To load the meeting with time, click ``Load =`` under the "Meetings"-"_somedate_", and you will see the people of meetings.

### Add/Remove

To add/remove the calendar, page is expected to under the "Calendars"-"All".

To add/remove the timeplot, page is expected to under the "Timeplots"-"_somename_". 

To add/remove the meetings, page is expected to under the "Meetings"-"_somedate_". 


## Structure

- ems (Main.java)
- controller
- model
- storage
- view