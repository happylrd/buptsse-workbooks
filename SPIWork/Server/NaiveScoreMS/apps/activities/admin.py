from django.contrib import admin

from .models import Activity


class ActivityAdmin(admin.ModelAdmin):
    list_display = ('name', 'desc', 'score', 'has_passed', 'start_time', 'end_time',)
    search_fields = ('name',)
    list_filter = ('name', 'score', 'has_passed', 'start_time', 'end_time',)


admin.site.register(Activity, ActivityAdmin)
