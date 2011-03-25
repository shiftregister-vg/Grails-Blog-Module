package org.stevegood.blog

import grails.test.*

class TagTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testToUri() {
		Tag tag = new Tag(label:"Groovy & Grails")
		assertEquals "groovy-grails", tag.toUri()
    }
}
