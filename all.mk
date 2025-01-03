# 2025 tvyiutnhisokewt

# Required makefiles. Also hard include pif.mk to avoid null pihook variables.
include vendor/tvyiutnhisokewt/configs/makefile/vars.mk
include vendor/tvyiutnhisokewt/configs/makefile/props.mk
include vendor/tvyiutnhisokewt/configs/makefile/pif.mk
include vendor/tvyiutnhisokewt/configs/makefile/fonts.mk

# Pixel style
$(call inherit-product, vendor/tvyiutnhisokewt/pixel-style/config/common.mk)

# Pixel framework
$(call inherit-product, vendor/tvyiutnhisokewt/pixel-framework/config.mk)
