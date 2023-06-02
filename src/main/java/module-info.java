module none.mydomain.personmanager.backend {

    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens none.mydomain.personmanager.backend to org.hibernate.orm.core;

    exports none.mydomain.personmanager.backend;
}
