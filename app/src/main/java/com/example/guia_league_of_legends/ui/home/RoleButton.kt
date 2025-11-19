package com.example.guia_league_of_legends.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.guia_league_of_legends.R

@Composable
fun RoleButton(role: String, iconRes: Int, navController: NavController) {
    Button(
        onClick = { navController.navigate("champions/$role") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF231F1F),
            contentColor = Color(0xFFFFD700)
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = role,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = role, style = MaterialTheme.typography.bodyLarge)
        }
    }
}