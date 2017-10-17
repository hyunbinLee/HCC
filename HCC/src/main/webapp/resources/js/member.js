$(document).ready(function() {
  
  var $wrapper = $('#member-wrapper'),
      $allTabs = $wrapper.find('.member-content > div'),
      $tabMenu = $wrapper.find('.member-menu li'),
      $line = $('<div class="line"></div>').appendTo($tabMenu);
  
  $allTabs.not(':first-of-type').hide();  
  $tabMenu.filter(':first-of-type').find(':first').width('100%')
  
  $tabMenu.each(function(i) {
    $(this).attr('data-member', 'member'+i);
  });
  
  $allTabs.each(function(i) {
    $(this).attr('data-member', 'member'+i);
  });
  
  $tabMenu.on('click', function() {
    
    var dataTab = $(this).data('member'),
        $getWrapper = $(this).closest($wrapper);
    
    $getWrapper.find($tabMenu).removeClass('active');
    $(this).addClass('active');
    
    $getWrapper.find('.line').width(0);
    $(this).find($line).animate({'width':'100%'}, 'fast');
    $getWrapper.find($allTabs).hide();
    $getWrapper.find($allTabs).filter('[data-member='+dataTab+']').show();
  });

});//end ready