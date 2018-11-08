package com.example.mjcan.mainkey

class acc_node {
    var next: acc_node? = null
    var prev: acc_node? = null
    var data: AccountInfo? = null
}


class AccountInfo(accName: String, accUsername: String, accPass: String, count: Int) {
    /*
    Info for each account entry created by the user
     */


    var accountName: String? = null
    var accountUsername: String? = null
    var accountPassword: String? = null
    var ID: Int? = null


    init {
        accountName = accName
        accountUsername = accUsername
        accountPassword = accPass
        ID = count
    }

    /*
    Info to handle the linked list
     */
    private var head: acc_node? = null
    var isEmpty: Boolean = head == null


    /*
    functions
     */
    fun firstNode(): acc_node? = null
    fun lastNode(): acc_node? {
        var node = head
        if (node != null){
            while (node?.next != null) {
                node = node.next
            }
            return node
        } else {
            return null
        }
    }
    fun insertBack(data: AccountInfo){
        var newNode = acc_node()
        newNode.data = data
        var lastNode = this.lastNode()
        if (lastNode != null){
            newNode.prev = lastNode
            lastNode.next = newNode
        }
        else {
            head = newNode
        }
    }
}



