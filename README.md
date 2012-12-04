Interactive-Hibernate-Console-With-Groovy
=========================================

Interactive Hibernate Console With Groovy And Spring

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


sessionFactory = context.getBean 'sessionFactory'

def transactionContext = { Session session, Closure c -> 
    Transaction tx = session.beginTransaction();
    try {
        c()
        tx.commit()
     } catch (e) {
        tx.rollback()
        throw e
     }
 }
 
 
transactionContext(sessionFactory.currentSession) { 
    // within transaction
}
```