package com.example.todofflist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationItem.Home.route){
        composable(NavigationItem.Home.route){
            FirstActivity(navController)
        }
        composable(NavigationItem.Second.route){
            SecondActivity(navController)
        }
        composable(NavigationItem.Third.route){
            TextActivity(navController)
        }
        composable(NavigationItem.Fourth.route){
            val ftodos = it.arguments?.getString("f_todos")
            if (ftodos != null) {
                FormalActivity(ftodos = ftodos)
            }
        }
        composable(NavigationItem.Fifth.route){
            val iftodos = it.arguments?.getString("if_todos")
            if (iftodos != null) {
                InFormalActivity(iftodos = iftodos)
            }
        }
    }
}

@Composable
fun FirstActivity(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(Color.parse("#4285f4"))
    ){
        Column(
            modifier =
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(
                painter = painterResource(id = R.drawable.homeimage),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = stringResource(id = R.string.TodoList), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(119.dp))
            Button(onClick = { navController.navigate("Second") },
                    shape = RoundedCornerShape(20.dp)) {
                Text(text = stringResource(id = R.string.GetStarted))
            }

        }


    }
}

@Composable
fun SecondActivity(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(
                Color.parse("#4285f4")
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally)

        {
            Button(onClick = { navController.navigate("Third") },
                shape = RoundedCornerShape(20.dp)) {
                Text(text = stringResource(id = R.string.formal))
            }
            Spacer(modifier = Modifier.padding(100.dp))
            Button(onClick = { navController.navigate("Third") },
                shape = RoundedCornerShape(20.dp)) {
                Text(text = stringResource(id = R.string.informal))
            }
        }


    }
}

@Composable
fun FormalActivity(ftodos: String){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(Color.parse("#4285f4"))
    ){
        Column(
            modifier =
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(
                painter = painterResource(id = R.drawable.homeimage),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = stringResource(id = R.string.formalPrint), fontWeight = FontWeight.Bold, fontSize = 30.sp)
            Spacer(modifier = Modifier.padding(25.dp))
            Text(text = ftodos)



        }


    }
}

@Composable
fun InFormalActivity(iftodos: String){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(Color.parse("#4285f4"))
    ){
        Column(
            modifier =
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(
                painter = painterResource(id = R.drawable.homeimage),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = stringResource(id = R.string.informalPrint), fontWeight = FontWeight.Bold, fontSize = 30.sp)
            Spacer(modifier = Modifier.padding(25.dp))
            Text(text = iftodos)



        }


    }
}

@Composable
fun TextActivity(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(
                Color.parse("#4285f4")
            )
    ) {
        val dummyvalue = remember { mutableStateOf(" ") }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        )
         {
            TextField(value = dummyvalue.value, onValueChange = {
                dummyvalue.value = it
            })
            Spacer(modifier = Modifier.padding(30.dp))
            Row(modifier = Modifier.wrapContentSize(Alignment.BottomCenter)) {
                Button(onClick = { navController.navigate("Fourth/${dummyvalue.value}") }, shape = RoundedCornerShape(20.dp
                )) {
                    Text(text = "Add TODO Formal")
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Button(onClick = { navController.navigate("Fifth/${dummyvalue.value}") }, shape = RoundedCornerShape(20.dp
                )) {
                    Text(text = "Add TODO InFormal")
                }
            }
        }

    }
}