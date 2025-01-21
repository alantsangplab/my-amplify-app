package com.plab.myamplifyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.plab.myamplifyapp.ui.theme.MyAmplifyAppTheme


import com.amplifyframework.ui.authenticator.ui.Authenticator
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import com.amplifyframework.core.Amplify

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAmplifyAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    Authenticator { state ->
                        Column {
                            Text(
                                text = "Hello ${state.user.username}!",
                            )

//                            TodoList()

//                            Button(onClick = {
//                                val todo = Todo.builder()
//                                    .content("My first todo")
//                                    .build()
//
//
//                                Amplify.API.mutate(
//                                    ModelMutation.create(todo),
//                                    { Log.i("MyAmplifyApp", "Added Todo with id: ${it.data.id}")},
//                                    { Log.e("MyAmplifyApp", "Create failed", it)},
//                                )
//                            }) {
//                                Text(text = "Create Todo")
//                            }

                            Button(onClick = {
                                Amplify.Auth.signOut {  }
                            }) {
                                Text(text = "Sign Out")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAmplifyAppTheme {
        Greeting("Android")
    }
}

//@Composable
//fun TodoList() {
//    var todoList by remember { mutableStateOf(emptyList<Todo>()) }
//
//    LaunchedEffect(Unit) {
//        // API request to list all Todos
//        Amplify.API.query(
//            ModelQuery.list(Todo::class.java),
//            { todoList = it.data.items.toList() },
//            { Log.e("MyAmplifyApp", "Failed to query.", it) }
//        )
//
//
//        Amplify.API.subscribe(
//            ModelSubscription.onCreate(Todo::class.java),
//            { Log.i("ApiQuickStart", "Subscription established") },
//            {
//                Log.i("ApiQuickStart", "Todo create subscription received: ${it.data}")
//                todoList = todoList + it.data
//            },
//            { Log.e("ApiQuickStart", "Subscription failed", it) },
//            { Log.i("ApiQuickStart", "Subscription completed") }
//        )
//    }
//
//    LazyColumn {
//        items(todoList) { todo ->
//            Row {
//                // Render your activity item here
//                Text(text = todo.content)
//            }
//        }
//    }
//}