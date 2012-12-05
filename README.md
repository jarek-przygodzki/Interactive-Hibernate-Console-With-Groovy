Interactive Hibernate Console With Groovy
=========================================

Interactive Hibernate Console With Groovy And Spring

![Screenshot](https://raw.github.com/jarek-przygodzki/Interactive-Hibernate-Console-With-Groovy/example/images/hibernate-groovy-console.png)

Compile
-------
```
mvn compile
```

Run
---
### Commmand line
```
mvn exec:java -Dexec.mainClass="jarekprzygodzki.hibernate_console.App" -Dexec.classpathScope=runtime
```

Create Eclipse project
----------------------
```
mvn eclipse:eclipse
```

Examples
========

```groovy
import org.hibernate.*

import jarekprzygodzki.hibernate_console.example.*


sessionFactory = context.getBean 'sessionFactory'

def transactionContext = { Session session, Closure c -> 
    Transaction tx = session.beginTransaction();
    try {
        c(session)
        tx.commit()
     } catch (e) {
        //Safe navigation operator
        tx?.rollback()
        throw e
     }
 }


transactionContext(sessionFactory.currentSession) { session->
    // within transaction
    Student s = new Student()
    s.studentName = 'John Doe'
    session.save(s)
}
```

```groovy
import org.hibernate.*

import jarekprzygodzki.hibernate_console.example.*


sessionFactory = context.getBean 'sessionFactory'

def transactionContext = { Session session, Closure c -> 
    Transaction tx = session.beginTransaction();
    try {
        c(session)
        tx.commit()
     } catch (e) {
        tx?.rollback()
        throw e
     }
 }


transactionContext(sessionFactory.currentSession) { session->
    // within transaction
     def q = session.createQuery('from Student')
     def students = q.list()
     students.each { s-> println "[id=$s.studentId, name=$s.studentName]"}
}
```