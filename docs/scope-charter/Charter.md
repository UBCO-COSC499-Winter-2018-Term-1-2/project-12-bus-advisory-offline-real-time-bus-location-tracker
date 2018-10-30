**Scope and Charter**

Offline First Real Time Bus Tracking

University Of British Columbia Okanagan

COSC 499

Authors:

| Document Owner(s) | Role             | Contact                 |
| ----------------- | ---------------- | ----------------------- |
| Wasek Habib       | Product Manager  | wasek.edu@gmail.com     |
| Matthew De Leeuw  | Integration Lead | mattdeleeuw@hotmail.com |
| Trevor Gallicano  | DevOps Lead      | trevorg@hotmail.ca      |
| Ini Oladosu       | Technical Lead   | inioladosu@gmail.com    |
| Kyle Rennie       | Client Liaison   | kyrenzie@gmail.com      |

Document History:

<table>
<thead>
<tr class="header">
<th><blockquote>
<p>Version</p>
</blockquote></th>
<th><blockquote>
<p>Date</p>
</blockquote></th>
<th><blockquote>
<p>Document Revision Description</p>
</blockquote></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>1.0</td>
<td>October 23, 2018</td>
<td><blockquote>
<p>Initial document</p>
</blockquote></td>
</tr>
</tbody>
</table>

**Table of Contents**

1.  > **Identification**

2.  > **Project Purpose**

3.  > **Project Objectives**

4.  > **Success Criteria**

5.  > **Scope Statement**
    
    1.  > **Out of Scope**

6.  > **Requirements**
    
    2.  > **Functional Requirements**
    
    3.  > **Non-functional Requirements**
    
    4.  > **Technical Requirements**
    
    5.  > **User Requirements**

7.  > **Work Breakdown Structure **

8.  > **Assumptions**

9.  > **Environmental Constraints**

10. > **Risks**

11. > **Project Development Methodology**

12. > **Project Milestones**

13. > **UML Use Case Diagram**

14. > **Approvals**

# 1\. Identification

Name of Project: Offline First Real-time Bus Tracking App

Sponsor: Fremtid Media

Project
Stakeholders:

| **Stakeholder Names**               | **Roles**                                             |
| ----------------------------------- | ----------------------------------------------------- |
| Fremtid Media                       | Sponsor/Client                                        |
| Reza Afzali                         | Client                                                |
| Simranpal Bains                     | Client                                                |
| Scott Fazackerley                   | Instructor/Supervisor                                 |
| UBCO Students/ Residents of Kelowna | Users                                                 |
| COSC Capstone Team 12               | Android App Developers                                |
| Engineering Capstone Team           | Hardware/Infrastructure Team                          |
| University of British Columbia      | Academic Institution                                  |
| BC Transit                          | Open Data Provider                                    |
| FirstCanada                         | Kelowna Public Bus Transportation Operator            |
| Kontakt.io                          | Beacon Provider                                       |
| Google                              | Android OS Provider                                   |
| Here                                | Maps API Provider for Showing Bus Location on the App |

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
<p>Involved in design and development process.</p>
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
<p>Involved in development process</p>
</blockquote></li>
</ul></td>
</tr>
</tbody>
</table>

# 2\. Project Purpose

Currently there is a ridership of 4.9 million in Kelowna per year, a
fair amount of riders (\>1%) use the transit app, with this app we are
looking to take a portion of the demand for maps and transit for this
app. Current apps have issues with telling the user the real time of
their bus arrival because they are unreliably crowdsourced, or just use
the bus schedule for times. This app will make transit passengers be
better notified about their bus whereabouts and when they should be
leaving to meet the busses arrival at an optimal time. They will be able
to view the exact whereabouts of the bus on the map and get notified
when a bus is on its way with its expected arrival time and they will
also be notified when a bus as left the bus stop if they are not on it.
If the project is not completed on time then the company overseeing it
can chose to continue with a new or the same team. They would have
prototypes and documentation to help them continue with the project,
even with a new team.

# 3\. Project Objectives

Create a mesh network with provided beacons and then create an app that
draws information from the network. The app should notify users with a
busses expected arrival time and when the bus has left the stop if they
are not on it. They should also be able to track a busses exact location
when in the mesh network.

# 4\. Success Criteria

  - > The app will have simple and elegant user experience following
    > standard human computer interaction rules.

  - > User satisfaction will be measured by a standardized set of
    > questions followed by the usability test and will measure 3 or
    > higher on a 5 point scale.

  - > The user interface will follow the best UI practices and ‘material
    > design’ standards.

  - > Response time will not be more than 2-3 seconds assuming the
    > application is awake and fully running on the device.

## 

# 5\. Scope Statement

The offline first android app (proof of concept) will show the user live
location and arrival time of the bus (real-time bus schedule) in nearby
bus stops. The user will get a push notification of the remaining
arrival time of the subscribed bus number when he/she is in a certain
range of the beacon at the bus stops. The beacons will be installed and
configured by the engineering team, which create a mesh network. The
application will receive the bus/car information through Bluetooth Low
Energy (BLE) provided by the mesh network. If the user clicks on the
push notification, it will take him/her to the app and show the live
location of the bus on the map. The users will not need an account to
use the application. Personal information of the users will not be asked
or stored. However, their travel time and distance will be stored
anonymously on device and uploaded to the cloud upon internet
connection.

## 5.1. Out of Scope

  - > COSC team is responsible for anything related to the server,
    > android application (both development and deployment) and its
    > connection to the beacons (software side). Anything outside of
    > that will be taken care of the engineering team.

  - > Data protection and transmission security of the beacons.
    > Kontakt.io is responsible for secured data transmission of the
    > beacons.

  - > The coverage area will not be outside of UBCO roundabout and EME
    > bus stop.

  - > Setting up the beacons, checking physical conditions and health.

  - > Creating mesh network.

  - > People with strollers or wheelchairs (physically impaired).

  - > Setting up and working with speakers and displays on bus-stops.

  - > Any communication between speakers, beacons, and light sensors.

<!-- end list -->

  - > Any kind of hardware implementation, security, and maintenance.
    > The engineering team is responsible for that.

  - > Cost analysis.

  - > Wayfinding (Navigation and in-between stops).

# 6\. Requirements

## 6.1. Functional Requirements

  - > Android application will connect to the beacon mesh network using
    > low-energy bluetooth.

  - > Application will display a map with the bus locations.

  - > Application will ask for user’s permission to access location.

  - > System will track the live position of busses.

  - > Application will display bus position even while the device is
    > offline.

  - > Application will display the expected arrival times of busses.

  - > User will receive a push notification when they are within a set
    > distance of a bus stop beacon.

  - > User will be notified about the wait time for the next arriving
    > bus.

  - > Application will be available to all users with no registration.

  - > Application will show a list of nearby bus/car(s) that has/have
    > beacon installed.

  - > App will track the current location of a user in the background.

  - > App will track travel distances and travel times of a user.

  - > Travel data will be stored on the device anonymously.

  - > Travel data will be sent to an online database when the device has
    > an online connection.

  - > Travel times will be deleted from device after they are sent to an
    > online database.

  - > Admins will be able to view data stored in the online database.

## 6.2. Non-Functional Requirements

### Development

  - > Developed as an Android application written in java.

  - > Development process will be completed using the agile method.

  - > Application will use third-party API’s.

  - > Costs for development (such as cloud service or third party API’s)
    > will be covered by the client.

###  Performance

  - > User must be outdoors on the UBCO campus and within the maximum
    > range of the mesh network (approximately 50m).

  - > Software will handle number of users equal to all bus commuters at
    > UBCO.

  - > Software will be scalable up to the entire 97 bus route in
    > Kelowna.

  - > Application will display bus positions accurate within 100 meters.

  - > Bus position will be updated within 3 seconds (including screen
    > latency).

  - > System requires all beacons to be functioning.

  - > System downtime limited to time spent replacing beacons.

  - > Bus tracking will be done with no internet connection.
    
      - > System uses low-energy bluetooth to communicate with
        > application.

  - > Bus tracking will only show information related to the next
    > bus(es).

  - > System can track any bus (with a beacon) within the mesh network.

  - > Travel times will be stored on device while the device is
offline.

## 6.3. Technical Requirements 

| **Tools/Languages/Libraries** | **Type**                              |
| ----------------------------- | ------------------------------------- |
| Android Studio                | Development Environment               |
| Balsamiq                      | Wireframing                           |
| Adobe XD                      | Mockup                                |
| Docker                        | Container based software as a service |
| Jenkins/Travis                | CI Solution                           |
| Git                           | Version Control System                |
| Github                        | Version Control Hosting Service       |
| Trello                        | Project Management                    |
| Slack                         | Communication                         |
| SQLite                        | Relational Database                   |
| Couchbase Mobile              | NoSQL database                        |
| AWS/Firebase                  | Cloud Platform                        |
| Toggl                         | Time Tracking                         |
| Java                          | Client side Programming Language      |
| Node.js                       | Backend Programming Language          |
| Postman                       | API debugging and testing tool        |
| Swagger                       | API designing and documentation tool  |
| Here Maps                     | Maps API                              |

  - > The application will connect to the beacon mesh network using
    > Kontakt Beacon APIs. API key will be stored in the app.

  - > The application will display a map with the bus locations using
    > Here maps API and caching the latest location. API key will be
    > stored in the app.

  - > Application will ask for user’s permission to access to GPS,
    > bluetooth, and internet using AndroidManifest.xml file to ask for
    > user permission.

  - > System will track the live position of busses both online and
    > offline using Kontakt Beacon APIs and Here maps APIs. API keys
    > will be stored in the app.

  - > Application will display the expected arrival times of bus using
    > Kontakt Beacon APIs and Here maps APIs. API keys will be stored in
    > the app. Beacon UUIDs and geo-coordinates will be stored in the
    > database.

  - > User will receive a push notification when they are within a set
    > distance of a bus stop beacon using async push notification. User
    > location and desired bus location in the background will be
    > tracked using GPS and Kontakt Beacon APIs.

  - > Application will show a list of nearby bus/car(s) that has/have
    > beacon installed using Kontakt Beacon APIs and BLE. API keys will
    > be stored in the app.

  - > App will track the current location of a user in the background
    > using GPS.

  - > App will track travel distances and travel times of a user using
    > Here maps APIs to calculate the distance and time. API keys will
    > be stored in the app.

  - > Travel data will be stored on the device anonymously by using
    > instance id.

  - > Travel data will be sent to an online database when the device has
    > an online connection using /POST and /PATCH APIs.

  - > Travel times will be deleted from device after they are sent to an
    > online database using /GET and /DELETE APIs.

## 6.4. User Requirements 

  - > Use application without an account.

  - > User receives push notification when entering specified beacon
    > range.

  - > Users can track bus with map.

  - > User can see expected bus arrival time.

  - > Can not log in.

  - > Able to track single bus.

  - > Able to use application on Android device.

  - > Users are Identified by Instance
ID.

# 7\. Work Breakdown Structure

| Task List                                           | Owner(s) | Estimated Hours |      |      |        |       | Total Estimate   |
| --------------------------------------------------- | -------- | --------------- | ---- | ---- | ------ | ----- | ---------------- |
|                                                     |          |                 |      |      |        |       | 184.1            |
|                                                     |          |                 |      |      |        |       | Average Estimate |
| **Learning**                                        | All      | Ini             | Kyle | Matt | Trevor | Wasek | 41.6             |
| Android                                             |          | 17              | 15   | 20   | 12     | 10    | 14.8             |
| Maps                                                |          | 3               | 2    | 3    | 3      | 5     | 3.2              |
| Kontakt.io                                          |          | 5               | 3    | 3    | 3      | 5     | 3.8              |
| CI Tools                                            |          | 12              | 2    | 12   | 12     | 12    | 10               |
| AWS/Firebase                                        |          | 5               | 2    | 4    | 2      | 3     | 3.2              |
| Databases                                           |          | 2               | 2    | 4    | 2      | 3     | 2.6              |
| Node.js                                             |          | 5               | 5    | 4    | 4      | 2     | 4                |
|                                                     |          |                 |      |      |        |       |                  |
| **Meetings**                                        |          | 36              | 36   | 36   | 36     | 36    | 36               |
|                                                     |          |                 |      |      |        |       |                  |
| **Design**                                          | All      |                 |      |      |        |       | 14.3             |
| Documentation                                       |          | 5               | 15   | 4    | 5      | 16    | 9                |
| Paper Prototype                                     |          | 2               | 4    | 0.5  | 1      | 1     | 1.7              |
| WireFraming                                         |          | 3               | 2    | 1    | 1      | 2     | 1.8              |
| MockUp                                              |          | 3               | 2    | 2    | 1      | 1     | 1.8              |
|                                                     |          |                 |      |      |        |       |                  |
| **Development**                                     |          |                 |      |      |        |       | 43.8             |
| ***1. Maps API***                                   | TBD      |                 |      |      |        |       | 10.8             |
| 1.1 Integrate Maps Into GUI                         |          | 5               | 3    | 8    | 3      | 1     | 4.8              |
| 1.2 Show Where Bus is Located                       |          | 5               | 3    | 2    | 4      | 5     | 3.8              |
| 1.3 Get Directions from bus to stop                 |          | 2.5             | 1.5  | 3    | 2      | 2     | 2.2              |
|                                                     |          |                 |      |      |        |       |                  |
| ***2. Kontakt Beacon API***                         | TBD      |                 |      |      |        |       | 13.2             |
| 2.1 Get Data From Mesh Network for Testing Purposes |          | 4               | 4    | 3    | 3      | 3     | 3.4              |
| 2.2 Get acceleration from beacons                   |          | 4               | 3    | 1    | 1      | 1     | 2                |
| 2.3 Get locations from beacons                      |          | 5               | 4    | 6    | 3      | 5     | 4.6              |
| 2.4 Collect metadata from app and beacons           |          | 5               | 4    | 2    | 3      | 2     | 3.2              |
|                                                     |          |                 |      |      |        |       |                  |
| ***3. Android SDK***                                | TBD      |                 |      |      |        |       | 6.4              |
| 3.1 Collect GPS Data                                |          | 3               | 3    | 2    | 2      | 2     | 2.4              |
| 3.2 Store GPS Data                                  |          | 5               | 2    | 2    | 3      | 8     | 4                |
|                                                     |          |                 |      |      |        |       |                  |
| ***4. Build API***                                  | TBD      |                 |      |      |        |       | 13.4             |
| 4.1 Integrate Android with Cloud                    |          | 4               | 4    | 4    | 4      | 4     | 4                |
| 4.2 Local Database to Cloud Database Path           |          | 15              | 3    | 10   | 3      | 16    | 9.4              |
|                                                     |          |                 |      |      |        |       |                  |
| **Integration and Testing**                         | TBD      |                 |      |      |        |       | 32.4             |
| Ci Tools Setup                                      |          | 4               | 1    | 3    | 6      | 1     | 3                |
| Usability Testing                                   |          | 4               | 2    | 5    | 8      | 5     | 4.8              |
| Documentation                                       |          | 5               | 3    | 3    | 6      | 16    | 6.6              |
| Unit Testing                                        |          | 2               | 2    | 8    | 10     | 10    | 6.4              |
| Integration Testing                                 |          | 5               | 4    | 8    | 8      | 8     | 6.6              |
| Acceptance Testing                                  |          | 5               | 5    | 5    | 5      | 5     | 5                |
|                                                     |          |                 |      |      |        |       |                  |
| **Final Documentation and Presentation**            |          | 16              | 16   | 16   | 16     | 16    | 16               |

# 8\. Assumptions 

  - # UBCO will approve installing beacons on campus.

  - > A beacon will be set up in one bus upon approval from BC transit.
    > If not, the students will use their own transports. The
    > engineering team is responsible for this.

  - > The engineering team will be responsible for installing and
    > configuring beacons and will provide any help needed as soon as
    > possible when COSC team test them. Both team will be present
    > during the integration testing.

  - > The beacons given will work and respond as expected. The client
    > and engineering team are responsible for any faulty beacons and
    > hardware issues.

  - > The developers have knowledge of Git, Java and relational
    > databases.

  - > Third party APIs (i.e. maps API, beacon API) will work properly.

  - > The team built APIs will be public and will not ask for any
    > authentications.

  - > The cloud service (AWS/Firebase) will have at least 99% uptime.

  - > The beacon range will be 50-70 meters.

  - > The beacons will not be stolen or vandalized.

  - > The team will be agile, self-organized, and maintain synergy.

  - > Any expenditure including cloud service, third party APIs,
    > transportation logistics will be provided by the client.

  - > The communication between stakeholders will be prompt, clear, and
    > efficient.

  - > Each developer will be working a minimum of 8 hours during school
    > weeks.

  - > There will not be any requirement changes from the client after
    > October 16, 2018.

  - > The Beacon response time will be 1-2 seconds.

# 9\. Environmental Constraints

  - > Requires approval from UBCO and BC transit to install beacons on
    > campus and bus.

  - > The durability and performance of the beacons in Kelowna weather
    > is unknown.

  - > Limited in-person meeting with the client.

  - > Field testing will be challenging during hostile weather.

  - > Development tool licenses and term of service.

  - > No control over third party APIs and cloud service.

  - > Some tasks are dependent on the task completion of engineering
    > team and can not be done in parallel.

  - > Majority of the developers are not familiar with Android
    > ecosystem, building REST APIs with node.js, and NoSQL databases.

  - > Lack of domain knowledge will lead to unrealistic estimations.

  - > Time
constraint.

# 10\. Risks

| Risk                           | Likelihood | Severity | Mitigation Plan                                                                 |
| ------------------------------ | ---------- | -------- | ------------------------------------------------------------------------------- |
| Unfinished Project             | Medium     | High     | Plan to stay ahead of deliverables.                                             |
| Conflict with Engineering Team | Low        | High     | Frequent communication and transparency.                                        |
| Losing members                 | Low        | Medium   | Involve all team members in development so we can pick up where other left off. |
| Unmotivated Team Members       | Low        | High     | Constantly staying ahead of deliverable due dates                               |
| Faulty Beacons                 | Medium     | High     | Have as many as possible so we are not reliant on just a few.                   |
| Client company shut down       | Medium     | High     | Continue project with Scott.                                                    |
| No Control Over 3rd Party APIs | High       | Medium   | Study the APIs as much as we can so we call deal with any issues if they arise. |
| Environmental Constraints      | Medium     | High     | Have backup plans, which will be discussed with the client.                     |
| Beacon Security                | Medium     | High     | Change beacon provider or implement own security.                               |
| API Security                   | Low        | High     | Implement API key and authentication                                            |
| Device Security                | Low        | Low      | Delete device database as soon as possible.                                     |

## 

# 11\. Project Development Methodology

Scrumban methodology and Trello will be used for project management. The
sprints will be one week long starting from every Tuesday. Weekly sync
up, demo, planning meeting will be held on Monday. If Monday doesn’t
work out for some reason, the team will have meeting on Friday or
Tuesday before the class (not recommended). Backlog will be created in
each week’s planning based on the progress and priority. Every week the
developers will pick up the tasks from backlog they think they can
finish in that week. If a task seems big, sub tasks can be created under
that task. The tasks will have story points. 1 point represents 1 hour.
Everyone is expected to finish at least 80% of their workload each week,
although 100% is preferred. The rest can be carried forward to the next
week’s sprint. There is no need for daily scrum meeting as trello is
synced to the scrum channel. So everything knows who is working on what.

The developers will create and push commits to the branches named with
task numbers and create pull requests. Only integration lead or feature
owners can review code and merge pull requests to the “Development”
branch. The integration or devOps Lead will then update the master
branch. The code will be reviewed after running automated test cases and
a successful Jenkins build. Non-technical documents will be merged by
the technical lead.

# 12\. Project Milestones

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
<td>Scope and Charter Document &amp; Presentation</td>
<td>October 23th, 2018</td>
<td>YES</td>
</tr>
<tr class="even">
<td>Design Requirements Document &amp; Presentation</td>
<td>November 13th, 2019</td>
<td>NO</td>
</tr>
<tr class="odd">
<td>Integration Testing with the Engineering team</td>
<td>November 16th, 2019</td>
<td>NO</td>
</tr>
<tr class="even">
<td>MVP Presentations</td>
<td>January 8th, 2019</td>
<td>NO</td>
</tr>
<tr class="odd">
<td>Testing Documentation and Presentation</td>
<td>TBA</td>
<td>NO</td>
</tr>
<tr class="even">
<td>Final Deliverable</td>
<td>TBA</td>
<td>NO</td>
</tr>
<tr class="odd">
<td>Final Project Presentation</td>
<td>April 8-26</td>
<td>NO</td>
</tr>
</tbody>
</table>

# 13\. UML Use Case Diagram

## ![](media/image1.png)

# 

# 

# 

# 

# 14\. Approval 

> Product
> Manager:\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_
> 
> Signature:
> \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_
> 
> Project
> Sponsor:\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_
> 
> Signature:
> \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_
