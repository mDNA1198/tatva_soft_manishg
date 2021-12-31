package com.manish.tatvasoft.user_list

class UserListRepository constructor(private val userListService: UserListService) {

    fun getUserList(offset: Int, limit: Int) = userListService.getUserList(offset, limit)

}