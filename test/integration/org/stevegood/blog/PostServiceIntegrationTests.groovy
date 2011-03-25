package org.stevegood.blog

import grails.test.*

class PostServiceIntegrationTests extends GroovyTestCase {
    
	def postService
	
	protected void setUp() {
        super.setUp()
		postService = new PostService()
    }

    protected void tearDown() {
        super.tearDown()
		postService = null
    }

    void testCreatePost() {
		Post post = postService.createPost("Test Title","Test summary","Test body")
		assert post
		post.delete()
    }
	
	void testDeletePost() {
		Post post = postService.createPost("Test Title","Test summary","Test body")
		assert post
		assertNull postService.deletePost(post)
	}
	
	void testSavePost() {
		Post post = postService.createPost("Test Title","Test summary","Test body")
		assert post
		post.body = "A new test body"
		assert postService.savePost(post)
		post.delete()
	}
	
	void testGetPost() {
		Post post = postService.createPost("Test Title","Test summary","Test body")
		assert post
		
		Post post2 = postService.getPost(post.uri)
		assertEquals post, post2
		
		post.delete()
	}
}
