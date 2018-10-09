**Scope and Charter**

Offline First Real Time Bus Tracking

University Of British Columbia Okanagan

COSC 499

### Report Expectations (80%)

  - > (5%) Project charter

  - > Scope Statement Document including
    
      - > (5%) A description of the software you are building
    
      - > (5%) A precise set of the criteria that your client deems as
        > successful outcomes of your project
    
      - > (10%) A list of functional requirements
    
      - > (10%) A list of non-functional requirements
    
      - > (5%) A list of technical requirements
    
      - > (5%) A list of user requirements
    
      - > (2.5%) A list of environmental constraints

  - > (2.5%) A description of your proposed workflow and methodology
    > (what is the development process/how will it work)

<!-- end list -->

  - > (10%) Identification of user groups and a complete set of UML use
    > case diagrams (based on your initial assessment)

<!-- end list -->

  - > (20%) A simplified work/feature breakdown structure (see below for
    > details)

Authors:

| Document Owner(s) | Role             | Contact                 |
| ----------------- | ---------------- | ----------------------- |
| Wasek Habib       | Product Manager  | wasek.edu@gmail.com     |
| Matthew De Leeuw  | Integration Lead | mattdeleeuw@hotmail.com |
| Trevor Gallicano  | DevOps Lead      | trevorg@hotmail.ca      |
| Ini Oladosu       | Technical Lead   | inioladosu@gmail.com    |
| Kyle Rennie       | Client Liaison   | kyrenzie@gmail.com      |

DOCUMENT HISTORY

<table>
<thead>
<tr class="header">
<th><blockquote>
<p>Date</p>
</blockquote></th>
<th><blockquote>
<p>Document Version</p>
</blockquote></th>
<th><blockquote>
<p>Document Revision Description</p>
</blockquote></th>
<th><blockquote>
<p>Document Author</p>
</blockquote></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><blockquote>
<p>Oct 2nd 2018</p>
</blockquote></td>
<td><blockquote>
<p>1st Draft</p>
</blockquote></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>

APPROVALS

<table>
<thead>
<tr class="header">
<th><blockquote>
<p>Approval</p>
<p>Date</p>
</blockquote></th>
<th><blockquote>
<p>Approved</p>
<p>Version</p>
</blockquote></th>
<th><blockquote>
<p>Approver Role</p>
</blockquote></th>
<th><blockquote>
<p>Approver</p>
</blockquote></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>

TABLE OF CONTENTS

1\. BACKGROUND

**Project Objective**

**Stakeholder**

**Identification**

1.1. Current Situation

1.2. Problem Statement

1.4. Key Performance Indicators (Success Criteria)

2\. APPROACH

2.1. Solution Overview

2.2. In-Scope

2.3. Impacts on / Touch Points with Other Systems

2.4. Out-of-Scope

2.5. Deliverables

2.6. Timeline

**Assumptions & Constraints**

**Work Breakdown Structure**

**Approvals**

**7. Proposed Workflow/Methodology**

> **● **

**8.1 Workflow**

**UML Use Case**

2.7. Project Team Organization

2.8. Roles & Responsibilities

2.9. Project Risks

1.5. Effects of Not Doing Project

3.4. Contingencies

4\. APPENDIX

4.1. 1<sup>st</sup> Section of Appendix \<if needed\>

**1. Identification**

Name of Project: Real-time Bus Tracking App

Sponsor: Fremtid Media

Project
Stakeholders:

| **Stakeholder Names**               | **Roles**                                  |
| ----------------------------------- | ------------------------------------------ |
| Fremtid Media                       | Sponsor/Client                             |
| Reza Afzali                         | Client                                     |
| Simranpal Bains                     | Client                                     |
| Scott Fazackerley                   | Instructor/Supervisor                      |
| UBCO Students/ Residents of Kelowna | Users                                      |
| COSC Capstone Team 12               | Android App Developers                     |
| Engineering Capstone Team           | Hardware/Infrastructure Team               |
| University of British Columbia      | Academic Institution                       |
| BC Transit                          | Open Data Provider                         |
| FirstCanada                         | Kelowna Public Bus Transportation Operator |
| Kontakt.io                          | Beacon Provider                            |
| Google                              | Maps API and Android OS Provider           |

Team:

<table>
<thead>
<tr class="header">
<th><strong>Team Members</strong></th>
<th><strong>Roles</strong></th>
<th><strong>Responsibilities</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Wasek Habib</td>
<td>Product Manager</td>
<td><ul>
<li><blockquote>
<p>Primarily responsible for the project workflow, requirements engineering, software architecture, and ensuring SDLC.</p>
</blockquote></li>
<li><blockquote>
<p>Involves in design and development process.</p>
</blockquote></li>
</ul></td>
</tr>
<tr class="even">
<td>Ini Oladosu</td>
<td>Technical Lead</td>
<td><ul>
<li><blockquote>
<p>Responsible for the non coding documents</p>
</blockquote></li>
<li><blockquote>
<p>Responsible for UI Design of application</p>
</blockquote></li>
<li><blockquote>
<p>Involved in development process</p>
</blockquote></li>
</ul></td>
</tr>
<tr class="odd">
<td>Matthew De Leeuw</td>
<td>Integration Lead</td>
<td><ul>
<li><blockquote>
<p>Responsible for checking code before integration into master branch (aka) responsible for what gets deployed</p>
</blockquote></li>
<li><blockquote>
<p>Responsible for programming with team on seperate features</p>
</blockquote></li>
</ul></td>
</tr>
<tr class="even">
<td>Trevor Gallicano</td>
<td>DevOps Lead</td>
<td><ul>
<li><blockquote>
<p>Responsible for continuous integration/deployment</p>
</blockquote></li>
<li><blockquote>
<p>Responsible for automated testing</p>
</blockquote></li>
<li><blockquote>
<p>Involved in development process</p>
</blockquote></li>
</ul></td>
</tr>
<tr class="odd">
<td>Kyle Rennie</td>
<td>Client Liaison</td>
<td><ul>
<li><blockquote>
<p>Responsible for continuous client contact and logging conversation</p>
</blockquote></li>
<li><blockquote>
<p>Responsible for communicating clients wants</p>
</blockquote></li>
</ul></td>
</tr>
</tbody>
</table>

**2. Approach**

**3**. **Problem Statement/Project Objective**

**4. Measurable objectives and related success criteria**

**5. High level Requirements:**

**5.1 Functional**

**5.2 Non-functional**

**5.3 Technical**

**5.4 User**

**6. Assumptions and constraints**

**7. Scope Statement **

**In scope**

**Out scope**

**Feature Breakdown Structure **

**8. High level risks**

**9. Project milestones **

**11.. Approvals**

> 1\. BACKGROUND
> 
> 1.1. Problem Statement

Currently there is a ridership of 4.9 million in Kelowna per year, a
fair amount of riders (\>1%) use the transit app, with this app we are
looking to take a portion of the demand for maps and transit for this
app. Current apps have issues with real time because they are unreliably
crowdsourced, or just use the bus schedule for times. This causes people
missing busses, or having to wait for extended periods for the bus. This
wastes time for the average bus user, and promotes use of private
vehicles instead of bus use, impacting the environment negatively. This
app will make it easier to determine when one needs to leave for the
bus, by giving accurate bus times, promoting bus use and less of a
carbon footprint.

> 1.2. Scope Statement

The objective of the project is to create and launch an android app with
the following requirements by April of 2019. Requirements:

  - > connect to the beacons offline

  - > Use beacons to track a vehicle

  - > Use beacons to detect average arrival time

  - > Have a graphical user interface that shows a map

  - > Have a graphical user interface that shows a position of a chosen
    > bus

  - > Have a graphical user interface that shows the nearby bus
    > schedules with bus numbers and directions

  - > Be able to tap on bus number/direction and be able to track the
    > bus live offline

  - > Be able to receive notifications about soon to arrive busses that
    > are selected

  - > Be able to collect user data without collecting personal
    > information

  - > Connect to maps api online

  - > Get directions and show a graphical interface on how to get there

  - > App must be for android or ios

  - > Bus and directions search bar at top of the screen for gui

  - > User can use application without an account

  - 
> 1.3. Impact to Business and/or Stanford Community
> 
> \<This section should address the improved operations, efficiencies,
> cost savings and/or changes that will result from the proposed
> project. This section will help to alert Central Businesses and
> Distributed Users as to the extent and kinds of changes that will take
> place and should foster an understanding of upcoming change management
> necessary. Please be as specific as possible with respect to
> identification of the impacted user groups and the timing and nature
> of the change to their processes.\>
> 
> 1.4. Key Performance Indicators
> 
> \<List one or more KPI’s that allow the University to measure the
> operational efficiency, improved accuracy and/or effectiveness because
> of this project. An example is, “Decrease Average Turnaround Time per
> Invoice from 30 days to two weeks by EOY 2010.” The KPI is ‘Decrease
> Turnaround Time Per Invoice.'
> 
> If KPI’s cannot be defined then a list of success factors and/or
> benefits should be described in this section.\>
> 
> 1.5. Effects of Not Doing Project
> 
> \<This section should call out the impact of not completing the
> project
> 
> · Use clear, business centric language to articulate the effect
> 
> · Next effect\>
> 
> 2\. APPROACH
> 
> 2.1. Solution Overview
> 
> \<This section should communicate the high-level solution as proposed
> by this project charter. Further sections of this project will provide
> more detail.\>
> 
> 2.2. In-Scope
> 
> \<This section should clearly define the scope of the solution. A
> bulleted list with a brief description would be helpful.\>
> 
> 2.3. Impacts on / Touch Points with Other Systems
> 
> \<This section should identify the integrations with other systems
> inside and outside of AS / ITS. Be sure to address impacts on upstream
> and/or downstream systems, identify whether an integration needs to be
> built or whether the impacted system is indirectly impacted. This
> section is import to complete as it may also affect other staff
> resources who may not be called out explicitly on the project.\>
> 
> 2.4. Out-of-Scope
> 
> \<This section should clearly define what is outside the scope of the
> solution. A bulleted list with a brief description would be helpful.
> Description should answer why an item is not considered in-scope.\>

Success Criteria:

  - > The app will have simple and elegant user experience following
    > standard human computer interaction rules

  - > User satisfaction will be measured by a standardized set of
    > questions followed by the usability test and will measure 3 or
    > higher on a 5 point scale.

  - > The user interface will follow the best UI practices and ‘material
    > design’ standards.

  - > The user interface will be similar to uber/google maps/transit
    > app.

  - > Response time should not be more than 2-3 seconds.

> 2.8. Assumptions and Constraints
> 
> Assumptions: the beacons given will work as expected; the api for the
> beacons works; the busses will follow the same route at all times; the
> beacons respond within a reasonable amount of 1-2 seconds; nobody will
> vandalize or steal the beacons
> 
> Constraints: using beacon technology; budget of $0; limited time and
> group size; limited amount of beacons to experiment with; not enough
> macs to develop for ios as well as android;
> 
> 2.9. Project Risks
> 
> \<Identify the assumptions that have a bearing on the project charter
> and that influenced your decisions in this document. Also include
> project risks and identify mitigation factors.\>

<table>
<thead>
<tr class="header">
<th><blockquote>
<p>Risk</p>
</blockquote></th>
<th><blockquote>
<p>Likelihood</p>
</blockquote></th>
<th><blockquote>
<p>Severity</p>
</blockquote></th>
<th><blockquote>
<p>Mitigation Plan</p>
</blockquote></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>

> 3\. REQUIREMENTS
> 
> 3.1. Functional Requirements

  - > Display an accessible map

  - > Display List of nearby busses

  - > Offline Bus Tracking

  - > Display distance of bus & Real-Time of arrival

  - > Search bar at top of the screen

  - > Even while the app is closed when a user gets near a beacon (bus
    > stop) they should receive a notification that says “the bus is
    > \_\_\_ far away”

  - > User should be able to change the range (distance) of when they
    > want the notification

  - > Everyone should be able to access all app features (No
    > registration)

> 3.2. Non-Functional Requirements

  - > User must be outdoors on the UBC campus

  - > Software will handle number of users equal to all commuters at
    > UBCO

  - > Software will be scalable up to Kelowna

  - > Bus tracking will represent bus location within 200 meters

  - > Bus position will be updated within 3 seconds (including screen
    > latency)

  - > System requires all beacons to be functioning

  - > System downtime limited to time spent replacing beacon batteries
    > (unknown time)

  - > Bus tracking will be done with no internet connection

  - > Bus tracking will only show information related to the next
    > bus(es)

  - > System can track any bus (with a beacon) within the mesh network

> 3.3. Technical
Requirements

| **Tools/Languages/Libraries** | **Type**                        | **Version** |
| ----------------------------- | ------------------------------- | ----------- |
| Android Studio                | Development Environment         |             |
| Balsamiq                      | Wireframing                     |             |
| Adobe XD                      | Mockup                          |             |
| Docker                        |                                 |             |
| Jenkins/Travis                | CI Solution                     |             |
| Git                           | Version Control System          |             |
| Github                        | Version Control Hosting Service |             |
| Trello                        | Project Management              |             |
| Slack                         | Communication                   |             |
| SQLite                        |                                 |             |
| Couchbase Mobile              |                                 |             |
| AWS/Firebase                  |                                 |             |
| Java                          |                                 |             |
| Node.js                       |                                 |             |
| Google/Here/Mapbox Maps       | API                             |             |

  - > Display an accessible map :
    
      - > Use maps API
    
      - > API key will be stored in the app

  - > Display List of nearby busses:
    
      - > Use GPS and maps API
    
      - > API key will be stored in the app

  - > Offline Bus Tracking
    
      - > Use Kontakt Beacon APIs
    
      - > API key will be stored in the app

  - > Display distance of bus & Real-Time of arrival
    
      - > Use Kontakt Beacon APIs and maps APIs
    
      - > API key will be stored in the app

  - > Search bar at top of the screen
    
      - > Use maps API to compute the direction
    
      - > API key will be stored in the app

  - > Even while the app is closed when a user gets near a beacon (bus
    > stop) they should receive a notification that says “the bus is
    > \_\_\_ far away”
    
      - > Use async push notification
    
      - > Track user location and desired bus location in the background
        > using GPS and Kontakt Beacon APIs

> 3.4. User Requirements

  - > <sup>Use application twithout an account</sup>

  - > <sup>App should function as a user would expect from similar
    > applications</sup>

  - > <sup>A user can track a bus online using google maps</sup>

  - > <sup>Users can track nearby busses without an internet
    > connection</sup>

  - > <sup>A user can expect push notifications when the bus is arriving
    > soon based on their location</sup>

  - > <sup>A user should not get a notification if they are on the bus
    > and it is leaving</sup>

> 3.5. Regulatory Requirements
> 
> 3.3. Software Requirements

**Work Breakdown Structure**

![](media/image2.jpg)

> 4\. APPENDIX
> 
> 4.1. 1<sup>st</sup> Section of Appendix\<if needed\>
> 
> 8\. High Level Risks

  - > We Don’t Finish on time

  - > Beacon goes down

  - > Their company goes under

Methodology:

Scrumban- Trello

Weekly meeting- (Monday)sync up, demo, planning. If Monday doesn’t work
out for some reason, we will have meeting on Friday or Tuesday before
the class (not recommended)

1 week sprint

Backlog will be created in each week’s planning based on the progress
and priority.

Every week the developers will pick up the tasks from backlog they think
they can finish in that week. If a task seems big, sub tasks can be
created under that task. Everyone is expected to finish at least 80% of
their workload each week, although 100% is preferred. The rest can be
carried forward to the next week.

No need for daily scrum meeting as trello is synced to the scrum
channel. So everything knows who’s working on what.

> 10\. Project Milestones / Deliverables

<table>
<thead>
<tr class="header">
<th><blockquote>
<p>Milestones / Deliverables</p>
</blockquote></th>
<th>Due Date</th>
<th>Complete (YES / NO)</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>1st Meeting with Scott</td>
<td>October 2nd 2018</td>
<td></td>
</tr>
<tr class="even">
<td>Scope and Charter Document</td>
<td>TBA</td>
<td>NO</td>
</tr>
<tr class="odd">
<td>Design Requirements Document</td>
<td>TBA</td>
<td>NO</td>
</tr>
<tr class="even">
<td>User Testing Requirements Document</td>
<td>TBA</td>
<td>NO</td>
</tr>
<tr class="odd">
<td>End of Semester Deliverable</td>
<td>TBA</td>
<td>NO</td>
</tr>
<tr class="even">
<td>Final Deliverable</td>
<td>TBA</td>
<td>NO</td>
</tr>
<tr class="odd">
<td>Presentation</td>
<td>TBA</td>
<td>NO</td>
</tr>
</tbody>
</table>

> **12. Approval**
> 
> Project
> Manager:\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_
> Signature:
> \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_
> 
> Project
> Sponsor:\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_
> Signature:
> \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_
