# -*- coding: utf-8 -*-
# Generated by Django 1.9.8 on 2017-03-31 07:45
from __future__ import unicode_literals

import datetime
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('users', '0001_initial'),
        ('activities', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='StudentActivity',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('has_finished', models.BooleanField(default=False, verbose_name='\u662f\u5426\u5df2\u5b8c\u6210')),
                ('add_time', models.DateTimeField(default=datetime.datetime.now, verbose_name='\u6dfb\u52a0\u65f6\u95f4')),
                ('activity', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='activities.Activity', verbose_name='\u6d3b\u52a8')),
                ('student', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='users.Student', verbose_name='\u5b66\u751f')),
            ],
            options={
                'verbose_name': '\u5b66\u751f\u6d3b\u52a8',
                'verbose_name_plural': '\u5b66\u751f\u6d3b\u52a8',
            },
        ),
    ]
