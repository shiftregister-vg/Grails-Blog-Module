package org.stevegood.blog

class PostService {

    static transactional = true

    Post createPost(String title, String summary, String body) {
		savePost(new Post(title:title,summary:summary,body:body))
    }
	
	Post getPost(String uri){
		Post.findByUri(uri)
	}
	
	def deletePost(Post post){
		post.delete(flush:true)
	}
	
	Post savePost(Post post){
		post.prepareBean()
		post.save(flush:true,failOnError:true)
	}
}
