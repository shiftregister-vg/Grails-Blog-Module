package org.stevegood.blog

import grails.test.*

class PostTests extends GrailsUnitTestCase {
    
	def post
	
	protected void setUp() {
        super.setUp()
		post = new Post()
    }

    protected void tearDown() {
        super.tearDown()
		post = null
    }

    void testToUri() {
		post.title = "A Test Post"
		assertEquals "a-test-post", post.toUri()
		
		post.title = "A Test Post & Stuff"
		assertEquals "a-test-post-stuff", post.toUri()
    }
}
