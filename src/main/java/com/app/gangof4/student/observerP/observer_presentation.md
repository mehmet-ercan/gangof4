---
theme: gaia
_class: lead
paginate: true
backgroundColor: #fff
backgroundImage: url('https://marp.app/assets/hero-background.svg')
---

![bg left:30% 100%](https://refactoring.guru/images/patterns/content/observer/observer.png)

# **Observer Design Pattern**

<br>

#### Also known as: Event-Subscriber, Listener

<br>
<br>
<br>

<style scoped>
h6 {
    color: gray;
    font-size: 25px;
}

h5 {
    color: gray;
    font-size: 18px;
}
</style>

###### mehmet ercan akcan
##### 12.06.2026

---

# Purpose :bookmark_tabs:

- behavioral design pattern
- lets you define a subscription mechanism 
  - to notify multiple objects about any events that 
  - happen to the object they’re observing.

---

# Problem :confused:

![bg w:900](https://refactoring.guru/images/patterns/content/observer/observer-comic-1-en-2x.png?id=8e89674eb83b01e82203987e600ba59e)

---

# Solution :sunglasses:

- The Subject keeps a list of observers and notifies them when its state changes.
- Observers implement an update method to react to notifications.
- This creates a simple subscription mechanism and keeps classes loosely coupled.

---

# Structure (roles) :bricks:

- Subject (or Observable): manages observers, provides attach/detach/notify.

- Observer: interface with update() method.

[//]: # (ConcreteSubject: stores state and notifies observers on change.)
- ConcreteObserver: reacts to updates, keeps a reference to Subject if needed.

---

# When to use :point_right:

- You need to notify many objects about changes in one object.
- You want loose coupling between sender and receivers.
- Observers should be added or removed at runtime.
- Example triggers: user actions, data changes, external events.

---

# Problems it solves :wrench:

- Broadcasts state changes to many dependents without hard links.
- Avoids tight coupling between components.
- Simplifies adding new observers without changing the subject.

---

# Real-world examples :earth_americas:

- News feed / subscription services
 
- Google/Whatsapp Groups: users subscribe to a group and receive updates when new messages are posted.

- GUI event listeners (button clicks, input change).

- MVC frameworks: View updates when Model changes.

---

# Sequence (how it works) :gear:

1. Observers subscribe to the Subject.
2. Subject state changes (or an event occurs).
3. Subject calls notify() which calls update() on each Observer.
4. Observers query the Subject (pull) or receive data (push) and update themselves.

---

# Benefits and Drawbacks :balance_scale:

- Benefits:
  - Reduced coupling between components.
  - Flexible: observers can be added/removed at runtime.
  - Good for event-driven systems.
- Drawbacks:
  - Can be hard to trace control flow (many callbacks).
  - Risk of memory leaks if observers are not removed.
  - Notification ordering and timing can be tricky.

---

# Related patterns :link:

- Mediator (centralizes complex interactions instead of broadcasting).
- Command (encapsulates actions that might be sent as notifications).

---

# Where we use it in our projects :construction:

---

# Manual code example :computer:

---

# Questions :question:

- Q ...
- u ..
- e .
- s
- .
