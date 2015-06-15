package com.foo.bar.deployment;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

@ArquillianSuiteDeployment
@RunWith(Arquillian.class)
public abstract class Deployments {

    private static final String[] TEST_PACKAGE_NAME = { "com.foo.bar" };

    @SuppressWarnings("unused")
    @Deployment
    public static Archive<?> createPortingToolDeployment() {

        return ShrinkWrap.create(WebArchive.class, "BugDemo.war")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addPackages(true, TEST_PACKAGE_NAME)
                ;
    }
}
