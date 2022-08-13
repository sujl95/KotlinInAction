package chapter3

class DuplicateCodeExample {
}

class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can 't save user user $id}: empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
//    1. 코드 중복 예제
//    if(user.name.isEmpty()) {
//        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
//    }
//    if(user.address.isEmpty()) {
//        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
//    }

//    2. 로컬 함수를 사용해 코드 중복 줄이기
//    fun validate(user: User, value: String, fieldName: String) {
//        if (value.isEmpty()) {
//            throw IllegalArgumentException("Can 't save user ${user.id}: empty $fieldName")
//        }
//    }
//    validate(user, user.name, "Name")
//    validate(user, user.address, "Address")

//    3. 로컬 함수에서 바깥 함수의 파라미터 접근하기
//    fun validate(value: String, fieldName: String) {
//        if (value.isEmpty()) {
//            throw IllegalArgumentException("Can 't save user ${user.id}: empty $fieldName")
//        }
//    }
//
//    validate(user.name, "Name")
//    validate(user.address, "Address")

    user.validateBeforeSave()

}

fun main() {
    val user = User(1, "", "")
    saveUser(user)
}